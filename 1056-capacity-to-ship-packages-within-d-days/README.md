<h2><a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days">Capacity To Ship Packages Within D Days</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>A conveyor belt has packages that must be shipped from one port to another within <code>days</code> days.</p>

<p>The <code>i<sup>th</sup></code> package on the conveyor belt has a weight of <code>weights[i]</code>. Each day, we load the ship with packages on the conveyor belt (in the order given by <code>weights</code>). We may not load more weight than the maximum weight capacity of the ship.</p>

<p>Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within <code>days</code> days.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> weights = [1,2,3,4,5,6,7,8,9,10], days = 5
<strong>Output:</strong> 15
<strong>Explanation:</strong> A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> weights = [3,2,2,4,1,4], days = 3
<strong>Output:</strong> 6
<strong>Explanation:</strong> A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> weights = [1,2,3,1,1], days = 4
<strong>Output:</strong> 3
<strong>Explanation:</strong>
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= days &lt;= weights.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= weights[i] &lt;= 500</code></li>
</ul>

---

# Solution
<p>This is binary search on ans.</p>
<p>The search space is <code>low = max of arr ele</code> and <code>high = total sum of the arr</code></p>
<p>The reason to take <code>low = max of arr ele</code> is the ship capacity should be atleast the max of ele</p>
<p>The reason to take <code>high = total sum of the arr </code> is, if <code>days = 1</code> we need to ship overall weight at single day.</p>
<p>Now, we guess a number in the search space(<code>mid</code>) as a capacity of the ship, and we check how many days it is taking to ship all the containers as per that capacity</p>
<p>If no.of days it taking to ship all the containers is <code><= days</code>, it means all the right part of the elements are possible, so we check the left part of the arr to minimise the capacity.</p>
<p>update <code>ans = mid</code></p>
<p>If no.of days it taking to ship all the containers is <code>> days</code>, it means it is taking too many days to ship the containers. so we much increase the capacity.so, we search on the right part of the arr.</p>
<p>At last we'll return <code>ans</code> or <code>low</code>. Both works.</p>
