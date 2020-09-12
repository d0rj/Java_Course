package com.d0rj;


public class Merger {

    public static void merge(Student[] a, Student[] l, Student[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i].compareTo(r[j]) == 0 || l[i].compareTo(r[j]) < 0)
                a[k++] = l[i++];
            else
                a[k++] = r[j++];
        }

        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }
    }


    public static void mergeSort(Student[] a, int n) {
        if (n < 2)
            return;

        int mid = n / 2;
        var l = new Student[mid];
        var r = new Student[n - mid];

        for (int i = 0; i < mid; i++)
            l[i] = a[i];

        for (int i = mid; i < n; i++)
            r[i - mid] = a[i];

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
}
