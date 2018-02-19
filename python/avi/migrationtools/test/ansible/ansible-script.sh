#!/bin/bash
    #cat test-playbook.dat > test.txt
    rm -rf ./Output/*.txt
    mkdir -p Output
    touch  ./Output/test_failure.txt
    touch  ./Output/passed.txt
    center() {
      termwidth="$(tput cols)"
      padding="$(printf '%0.1s' ={1..500})"
      printf '%*.*s %s %*.*s\n' 0 "$(((termwidth-2-${#1})/2))" "$padding" "$1" 0 "$(((termwidth-1-${#1})/2))" "$padding"
    }

    center "Successfully passed ansible playbooks" >> Output/passed.txt
    center "Errors occured in ansible playbooks" >> Output/test_failure.txt
    while read file;
    do
        echo $file
        fileName=$(cut -d' ' -f1 <<<$file)
         res=$(cut -d' ' -f2 <<<$file)
        change=$(cut -d'=' -f2 <<<$res)
        echo "=> " $fileName $change
        pytest ansible_test.py -vvvv --config $fileName --change $change | tee ./Output/$fileName.txt

        if grep -q failed "./Output/$fileName.txt"; then
             echo $fileName >> ./Output/test_failure.txt
             cat ./Output/$fileName.txt >> ./Output/test_failure.txt
        else
            echo $fileName >> ./Output/passed.txt
        fi
        rm -rf ./Output/$fileName.txt
    done < test-playbook.dat

    count=`awk 'END {print NR}' ./Output/test_failure.txt`
    if [ "$count" == 1 ]
    then
        rm -rf ./Output/test_failure.txt
    fi
    count=`awk 'END {print NR}' ./Output/passed.txt`
    if [ "$count" == 1 ]
    then
        rm -rf ./Output/passed.txt
    fi