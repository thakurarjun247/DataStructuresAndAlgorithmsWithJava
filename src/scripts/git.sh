#just run this file
# sh git.sh
# git.sh is the filename
cd /Users/arjthak/git/DataStructuresAndAlgorithmsWithJava/src
git checkout master
git pull
git add .
echo 'Enter the commit message:'
read commitMessage
git commit -m "$commitMessage"
git push origin master
echo 'Done!'
