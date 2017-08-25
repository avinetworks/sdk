set -e
set -x

go fmt session/*
go fmt models/*
go fmt clients/*
go fmt examples/*


golint session/*
golint models/*
golint clients/*
golint examples/*
