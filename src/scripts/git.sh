# just run this file
# sh git.sh
cd /Users/arjthak/git/DataStructuresAndAlgorithmsWithJava/src
git checkout master
git pull
git add .
echo 'Enter a commit message:'
read commitMessage
git commit -m "$commitMessage"
git push origin master
echo 'Done!'
