(ns quicksort.core)

(defn quick-sort [nums]
   (if (< (count nums) 2) nums
      (concat
          (quick-sort (filter #(< % (first nums)) nums))
          (filter #(= % (first nums)) nums)
          (quick-sort (filter #(> % (first nums)) nums)))))
