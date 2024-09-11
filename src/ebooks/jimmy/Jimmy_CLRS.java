package ebooks.jimmy;

//  https://docs.google.com/spreadsheets/d/14zUSvYf_LmbXFH-gzHIYkjsaPYzaQnzwlIJjs_IgfoU/edit#gid=0
/*

Chapter 3

All of it. You have to know big-O notation and time complexity analysis, period.

Chapter 4

4.1 Maximum subarray problem - Can kind of be worth your time. There are better solutions to this problem than divide and conquer but it's good practice and the flow of logic may help develop how you think.
4.2 Strassen's algorithm - I really love this algorithm and was astounded at how cool
 it was the first time I saw it, but you can skip it for the interviews. It won't come up.
4.3 Substitution method - you won't be using this method in an interview, but you should know it since it's a basic tool for finding the time complexity of a recursive algorithm.
4.4 Recurrence tree method - same as 4.3
4.5 Master method - essential knowledge. You should know it and practice with it and be able to use it in 3 seconds. This is the method you would use in an interview if analyzing a recursive algorithm that fits the form.
4.6 Proof of the master theorem - you can probably skip this, though it's good to read at least once so that you understand what you're doing with the master method.


Chapter 7

7.1, 7.2, 7.3 - Quicksort and its randomized version. Need-to-know concepts.
I also recommend 7.4 (I was once asked in an interview to high-level-analyze a randomized algorithm),
though the probability you have to deal with something like 7.4 in an interview is pretty low, I'd guess.

Chapter 8

8.2 - Counting sort - Need-to-know in detail. It comes up in disguised forms.
8.3 - Radix sort - Yup. It's an easy algorithm anyway.


Chapter 9

9.1 - Small section, worth a read.
9.2 - Selection in expected linear time - Very important, as it's not common knowledge like quicksort and yet it comes up often in interviews. I had to code the entire thing in an interview once.
9.3 - Selection in worst-case linear time - Can skip. Just know that it's possible in worst-case linear time, because that might help somewhat.

12.3 - Insertion/Deletion - Same as 12.2
12.4 - Randomly built BSTs - just know Theorem 12.4 (expected height of random BST is
O(logn) and an idea of why it's true.

Chapter 13

This one is easy. Know what a Red-Black tree is, and what its worst-case
 height/insert/delete/find are. Read 13.1 and 13.2, and skip the rest.
You will never be asked for RB-tree insert/delete unless the interviewer is "doing it wrong",
 or if the interviewer wants to see if you can re-derive the cases,
  in which case knowing them won't help much anyway (and I doubt this would happen anyway).
   Also know that RB-trees are pretty space-efficient and some C++ STL containers are built
   as RB-trees usually (e.g. map/set).

Chapter 14

Might be worth skimming 14.2 just to know that you can augment data structures \
and why it might be helpful. Otherwise do one or two simple problems on augmenting
data structures and you're set here. I'd skip 14.1 and 14.3.

Chapter 15

DP! Must-know.
15.1 - Rod-cutting. Standard DP problem, must-know.
15.2 - Matrix-chain multiplication - same as 15.1, though I don't particularly like the way this section is written (it's rare for me to say that about CLRS).
15.3 - Elements of DP - worth a read so that you understand DP properly, but I'd say it's less important than knowing what DP is (via the chapter introduction) and practicing on it (via the problems in this book and in interview preparation books).
15.4 - LCS - same as 15.1
15.5 - Optimal binary search trees - I've never read this section, so I can't argue for its importance, but I did fine without it.

Chapter 16
16.3 - Huffman codes - I'd say read the problem and the algorithm, but that's enough. I've seen interview questions where the answer
is Huffman coding (but the question will come up in a 'disguised form', so it won't be obvious.)


Chapter 18

You should probably have an idea of what B-Trees (and B+ trees) are, I've heard of cases where
 candidates were asked about them in a general sense (high-level questions about what they are and why they're awesome).
But other than that I'd skip this chapter.


Chapter 32
32.1 - Naive method - just read it quickly.
32.2 - Rabin-Karp - I'd say you should know this, the rolling hash concept is very important and can be useful in many string- or search-related interview problems.

Appendices

A - Summations
Know the important summations for time complexity analysis.

C - Counting and Probability
Give C.4 a read if you don't know the material, Bernoulli trials may come up in problems (not explicitly, but you might use them, specifically for time analysis of questions that involve probability/coin flips).

*/
public class Jimmy_CLRS {}

