/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_week_2_sesi_1;

/**
 *
 * @author LENOVO
 */
// If-Then
if (condition) {
    // Block of code to be executed if the condition is true
}

int age = 20;
if (age >= 18) {
    System.out.println("You are eligible to vote.");
}

// If-Then-Else
if (condition) {
    // Block of code executed if condition is true
} else {
    // Block of code executed if condition is false
}

int age = 15;
if (age >= 18) {
    System.out.println("You are eligible to vote.");
} else {
    System.out.println("You are not eligible to vote.");
}

int marks = 75;
if (marks >= 85) {
    System.out.println("Grade A");
} else if (marks >= 70) {
    System.out.println("Grade B");
} else {
    System.out.println("Grade C");
}

// Switch Statement
int month = 8; String name;
switch (month) {
  case 1: name="January"; break;
  // ...
  case 8: name="August"; break;
  default: name="Invalid"; break;
}

// switch multi-label
switch (month) {
  case 1: case 3: case 5: case 7: case 8: case 10: case 12: days=31; break;
  case 4: case 6: case 9: case 11: days=30; break;
  case 2: days = isLeap(year)?29:28; break;
  default: /* handle invalid */
}

// While
int i=1;
while (i<=10) { System.out.println(i); i++; }

// Do-while
int j=1;
do { System.out.println(j); j++; } while (j<=10);

// For
for (int k=1; k<=10; k++) {
    System.out.println(k);
}

// Enhanced for
int[] nums = {1,2,3,4,5};
for (int n : nums) {
  System.out.println(n);
}

// break (unlabeled)
int[] a={32,87,3,589,12};
int target=12; int idx=-1;
for (int i=0;i<a.length;i++){
  if(a[i]==target){ idx=i; break; }
}

// break berlabel
search:
for (int i=0;i<m.length;i++){
  for (int j=0;j<m[i].length;j++){
    if(m[i][j]==target){ found=true; break search; }
  }
}

// continue
int count=0; String s="peter piper picked...";
for (int i=0;i<s.length();i++){
  if (s.charAt(i)!='p') continue;
  count++;
}

// return
if (x<0) return;
return ++count; // harus cocok dengan tipe hasil method