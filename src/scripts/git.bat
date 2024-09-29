xz6@echo off
:: Change directory to your Git project folder
cd /d D:\git\DataStructuresAndAlgorithmsWithJava\src

:: Checkout master branch
git checkout master

:: Pull latest changes
git pull

:: Add all changes
git add .

:: Ask for commit message
set /p commitMessage="Enter a commit message: "

:: Commit with the entered message
git commit -m "%commitMessage%"

:: Push to the master branch
git push origin master

:: Print done message
echo Done!
