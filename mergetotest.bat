@echo off

echo merging development into test
git checkout test && git pull && git merge development --verbose && git push && git checkout development
