@echo off

echo merging test into production
git checkout production && git pull && git merge test --verbose && git push && git checkout development
