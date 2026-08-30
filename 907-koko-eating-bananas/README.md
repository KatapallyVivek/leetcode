<h2><a href="https://leetcode.com/problems/koko-eating-bananas">Koko Eating Bananas</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Koko loves to eat bananas. There are <code>n</code> piles of bananas, the <code>i<sup>th</sup></code> pile has <code>piles[i]</code> bananas. The guards have gone and will come back in <code>h</code> hours.</p>

<p>Koko can decide her bananas-per-hour eating speed of <code>k</code>. Each hour, she chooses some pile of bananas and eats <code>k</code> bananas from that pile. If the pile has less than <code>k</code> bananas, she eats all of them instead and will not eat any more bananas during this hour.</p>

<p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.</p>

<p>Return <em>the minimum integer</em> <code>k</code> <em>such that she can eat all the bananas within</em> <code>h</code> <em>hours</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> piles = [3,6,7,11], h = 8
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 5
<strong>Output:</strong> 30
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 6
<strong>Output:</strong> 23
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
	<li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
</ul>

<h1>Solution</h1>

<p>This problem is <b>Binary Search on Answer</b>.</p>

<p>Here, first we take <code>low = 1</code> and <code>high = maximum pile</code>.</p>

<p>Then we guess one eating speed and check whether Koko can eat all the bananas within <code>h</code> hours. The number we guess is <code>mid</code>.</p>

<p>We calculate the total number of hours required for Koko to eat all the bananas at speed <code>mid</code>.</p>

<p>If total hours are <code>&lt;= h</code>, it means Koko can eat all the bananas within the given time. But there is a chance that she can eat at an even smaller speed, so we search in the left part.</p>

<p>If total hours are <code>&gt; h</code>, it means Koko is taking more time than allowed. Therefore, she needs to eat faster, so we search in the right part.</p>

<p>At last, we return <code>low</code>, because when the binary search ends, <code>low</code> points to the <b>smallest valid eating speed</b>.</p>

<p>In other words, at the end:</p>

<pre>
low  = first valid speed
high = last invalid speed
</pre>

<p>Since the question asks for the <b>minimum possible eating speed</b>, we return <code>low</code>.</p>
