## Problem Statement:
Given two strings s1 and s2, find out if they only differ by the insertion of a phrase.

### Example:

s1: The boy goes to the hospital

s2: The cute little boy goes to the hospital

Explanation:

'cute litte' is the added phrase everything else is the same so return True

Example:

s1: The boy is nice.

s2: The girl is nice.

Answer: -> Return False


## Flow
1. If both lenths are same, then return false as there is no addition
2. Use 2 pointer approach to increment the matching starting pointers of both strings
3. Use the 2 pointer approach to decrement the pointers will there is mismatch.
4. Return true of any of the string has crossed bounds with its left and right pointers, means there is no insertion/deleting in it. Other string has additional insertions

## Solution



```java
public boolean differByPhase(String s1, String s2){
    if(s1.length()==s2.length()){
        return false;
    }
    int s1i=0;
    int s1j=s1.length()-1;
    int s2i=0;
    int s2j=s2.length()-1;
    while(s1i<s1j && s2i<s2j && s1.charAt(s1i)==s2.charAt(s2i)>){
        s1i++;
        s2i++;
    }
    while(s1j>=0 && s2j?=0 && s1.charAt(s1j)==s2.charAt(s2j)>){
        s1j--;
        s2j--;
    }
    return s1i>=s1j || s2i>=s2j;
    /*
    OR
    // Compute the length of the unmatched middle part for each string.
int unmatchedLengthS1 = s1j - s1i + 1;
int unmatchedLengthS2 = s2j - s2i + 1;

// If one of the strings has no unmatched characters (i.e., its unmatched segment length is <= 0),
// then the difference between the strings is just the inserted phrase.
return (unmatchedLengthS1 <= 0 || unmatchedLengthS2 <= 0);

    */

}


```

## Explanation


The condition

```java
return s1i >= s1j || s2i >= s2j;
```

serves as the final check to determine if the only difference between the two strings is an extra inserted phrase. Let’s break down how this works step by step.

---

### 1. Understanding the Two-Pointer Setup

We maintain four pointers:

- **s1i and s2i:** Start from the beginning of strings **s1** and **s2**, respectively.
- **s1j and s2j:** Start from the end of strings **s1** and **s2**, respectively.

The idea is to use two pointers from the left and two pointers from the right to match the common parts of the strings.

- **Left Matching:**  
  The loop
  ```java
  while(s1i < s1j && s2i < s2j && s1.charAt(s1i) == s2.charAt(s2i)){
      s1i++;
      s2i++;
  }
  ```
  moves the pointers from the beginning until the characters no longer match.

- **Right Matching:**  
  The loop
  ```java
  while(s1j >= 0 && s2j >= 0 && s1.charAt(s1j) == s2.charAt(s2j)){
      --s1j;
      --s2j;
  }
  ```
  moves the pointers from the end backwards until the characters differ.

After both loops, we have effectively “trimmed” the matching parts from the beginning and end of the strings. What remains in the middle of each string are the parts that do not match.

---

### 2. Explaining the Final Condition

After matching from both ends, there are a few possible scenarios:

1. **Extra Phrase Insertion:**  
   One string has extra characters in the middle compared to the other.  
   - The string with the inserted phrase will have an unmatched middle portion.
   - The other string, from which these extra characters are missing, will have no unmatched characters left; the pointers will have crossed each other.
   
2. **More than an Insertion:**  
   If both strings have unmatched segments (i.e., both pointers do not cross), it indicates that there are extra differences beyond a simple insertion (for example, a substitution or deletion), meaning they don't just differ by an inserted phrase.

The condition:
  
```java
return s1i >= s1j || s2i >= s2j;
```

is checked at the end:
- **`s1i >= s1j`:**  
  This checks if the left pointer and right pointer in **s1** have met or passed each other. If they have, it means **s1** has no “middle” unmatched section left after trimming the common beginning and the end. In other words, **s1** is entirely contained within **s2** except for an extra inserted phrase in **s2**.

- **`s2i >= s2j`:**  
  Similarly, this checks if the pointers in **s2** have crossed, indicating that **s2** has no extra unmatched section. In the context of the problem, if **s2** is the shorter string with nothing extra, then the extra phrase must have been removed from **s1**.

Thus, if **either** of these conditions holds true, it means that **all the differences between the two strings can be accounted for by a contiguous inserted (or removed) phrase**—and nothing else is different.

---

### 3. Summarizing With an Example

Consider the example provided:

- **s1:** "The boy goes to the hospital"  
- **s2:** "The cute little boy goes to the hospital"

**Left Matching:**  
- Both strings share "The " at the beginning. The pointers move past this common part.

**Right Matching:**  
- From the right, both share " goes to the hospital". The pointers will backtrack until the matching parts end.

After both matchings:
- **s1:** The unmatched section might be an empty string because every character outside the inserted phrase matches.
- **s2:** The unmatched section is "cute little" (the inserted phrase).

When we check:
- **s1i >= s1j** will be true if **s1** has no unmatched part left after trimming.
- Since **s1** is entirely in order relative to **s2** except for the extra insertion, the condition correctly returns `true`.

---

### Final Thoughts

The last condition is crucial—it verifies that the only difference between the strings is localized to one contiguous section that appears in one string and not the other. If both strings have remaining unmatched characters after the left and right pointers meet, then more than just an insertion is at play, and the method returns `false`.

This is how the final `if` (or return condition) distinguishes a simple phrase insertion from other types of differences.