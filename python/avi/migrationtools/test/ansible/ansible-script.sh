#!/bin/bash
    #cat test-playbook.dat > test.txt
    rm -rf ./updated_results/*.txt
    mkdir -p updated_results
    touch  ./updated_results/test_failure.txt
    touch  ./updated_results/passed.txt
    center() {
      termwidth="$(tput cols)"
      padding="$(printf '%0.1s' ={1..500})"
      printf '%*.*s %s %*.*s\n' 0 "$(((termwidth-2-${#1})/2))" "$padding" "$1" 0 "$(((termwidth-1-${#1})/2))" "$padding"
    }

    center "Successfully passed ansible playbooks" >> updated_results/passed.txt
    center "Errors occured in ansible playbooks" >> updated_results/test_failure.txt
    while read file;
    do
        echo $file
        fileName=$(cut -d' ' -f1 <<<$file)
         res=$(cut -d' ' -f2 <<<$file)
        change=$(cut -d'=' -f2 <<<$res)
        echo "=> " $fileName $change
        pytest ansible_test.py -vvvv --config $fileName --change $change | tee ./updated_results/$fileName.txt

        if grep -q failed "./updated_results/$fileName.txt"; then
             echo $fileName >> ./updated_results/test_failure.txt
             cat ./updated_results/$fileName.txt >> ./updated_results/test_failure.txt
        else
            echo $fileName >> ./updated_results/passed.txt
        fi
        rm -rf ./updated_results/$fileName.txt
    done < test-playbook.dat

    count=`awk 'END {print NR}' ./updated_results/test_failure.txt`
    if [ "$count" == 1 ]
    then
        rm -rf ./updated_results/test_failure.txt
    fi
    count=`awk 'END {print NR}' ./updated_results/passed.txt`
    if [ "$count" == 1 ]
    then
        rm -rf ./updated_results/passed.txt
    fi