<h2><a href="https://leetcode.com/problems/number-of-provinces">Number of Provinces</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>There are <code>n</code> cities. Some of them are connected, while some are not. If city <code>a</code> is connected directly with city <code>b</code>, and city <code>b</code> is connected directly with city <code>c</code>, then city <code>a</code> is connected indirectly with city <code>c</code>.</p>

<p>A <strong>province</strong> is a group of directly or indirectly connected cities and no other cities outside of the group.</p>

<p>You are given an <code>n x n</code> matrix <code>isConnected</code> where <code>isConnected[i][j] = 1</code> if the <code>i<sup>th</sup></code> city and the <code>j<sup>th</sup></code> city are directly connected, and <code>isConnected[i][j] = 0</code> otherwise.</p>

<p>Return <em>the total number of <strong>provinces</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/graph1.jpg" style="width: 222px; height: 142px;" />
<pre>
<strong>Input:</strong> isConnected = [[1,1,0],[1,1,0],[0,0,1]]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/graph2.jpg" style="width: 222px; height: 142px;" />
<pre>
<strong>Input:</strong> isConnected = [[1,0,0],[0,1,0],[0,0,1]]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 200</code></li>
	<li><code>n == isConnected.length</code></li>
	<li><code>n == isConnected[i].length</code></li>
	<li><code>isConnected[i][j]</code> is <code>1</code> or <code>0</code>.</li>
	<li><code>isConnected[i][i] == 1</code></li>
	<li><code>isConnected[i][j] == isConnected[j][i]</code></li>
</ul>


<p>** Interpretation of the Matrix:
Row 0 ({1, 1, 0, 0}): City 0 is connected to City 1 (1 in index 0 and 1), but not to City 2 or City 3 (0).
Row 1 ({1, 1, 0, 0}): City 1 is connected to City 0, but not to City 2 or City 3.
Row 2 ({0, 0, 1, 1}): City 2 is connected to City 3, but not to City 0 or City 1.
Row 3 ({0, 0, 1, 1}): City 3 is connected to City 2, but not to City 0 or City 1.
Goal:
We want to count the number of connected components (provinces). This means identifying how many separate groups of cities are connected, directly or indirectly.

Algorithm:
We start from each unvisited city and use DFS to mark all the cities connected to it.
Every time we start a DFS from an unvisited city, we increment the count of provinces.
We repeat this process for all cities.
DFS and findCircleNum Function Call Execution:
Initialization:

n = 4 (there are 4 cities).
visit = [false, false, false, false] (none of the cities are visited yet).
count = 0 (no provinces counted yet).
First Iteration (i = 0):

City 0 is not visited (visit[0] = false), so we start a DFS from City 0.
Increment count (now count = 1), indicating a new province.
DFS Call Stack:
DFS from City 0 (dfs(0)):
Mark City 0 as visited (visit[0] = true).
Explore the neighbors of City 0 (check the row corresponding to City 0 in the adjacency matrix).
isConnected[0][0] = 1 (self-loop, already visited).
isConnected[0][1] = 1 (City 0 is connected to City 1), so we start a recursive DFS on City 1.
DFS from City 1 (dfs(1)):
Mark City 1 as visited (visit[1] = true).
Explore the neighbors of City 1.
isConnected[1][0] = 1 (City 1 is connected to City 0, already visited).
isConnected[1][1] = 1 (self-loop, already visited).
isConnected[1][2] = 0 (no connection to City 2).
isConnected[1][3] = 0 (no connection to City 3).
Since all neighbors of City 1 have been explored, the DFS call for City 1 ends.

Back to DFS from City 0:

The DFS from City 0 has explored all its neighbors (City 1), so it ends.
At this point, Cities 0 and 1 have been visited, and we have completed exploring one connected component.

Second Iteration (i = 1):

City 1 is already visited (visit[1] = true), so we skip the DFS for City 1.
Third Iteration (i = 2):

City 2 is not visited (visit[2] = false), so we start a DFS from City 2.
Increment count (now count = 2), indicating another new province.
DFS Call Stack for Second Component:
DFS from City 2 (dfs(2)):
Mark City 2 as visited (visit[2] = true).
Explore the neighbors of City 2 (check the row corresponding to City 2 in the adjacency matrix).
isConnected[2][0] = 0 (no connection to City 0).
isConnected[2][1] = 0 (no connection to City 1).
isConnected[2][2] = 1 (self-loop, already visited).
isConnected[2][3] = 1 (City 2 is connected to City 3), so we start a recursive DFS on City 3.
DFS from City 3 (dfs(3)):
Mark City 3 as visited (visit[3] = true).
Explore the neighbors of City 3.
isConnected[3][0] = 0 (no connection to City 0).
isConnected[3][1] = 0 (no connection to City 1).
isConnected[3][2] = 1 (City 3 is connected to City 2, already visited).
isConnected[3][3] = 1 (self-loop, already visited).
Since all neighbors of City 3 have been explored, the DFS call for City 3 ends.

Back to DFS from City 2:

The DFS from City 2 has explored all its neighbors (City 3), so it ends.
At this point, Cities 2 and 3 have been visited, and we have completed exploring the second connected component.

Fourth Iteration (i = 3):
City 3 is already visited (visit[3] = true), so we skip the DFS for City 3.
Final Result:
The visit array is now [true, true, true, true], meaning all cities have been visited.
The count is 2, meaning there are two provinces.
Final Output:
cpp
Copy
return count;  // Returns 2
Summary of DFS Recursive Calls:
The first DFS starts at City 0 and visits City 1. This forms the first province.
The second DFS starts at City 2 and visits City 3. This forms the second province.
Thus, the number of provinces (connected components) is 2.**</p>
