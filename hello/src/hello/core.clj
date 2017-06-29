(ns hello.core
  (:gen-class))

(defn quick-sort [nums]
  (if (< (count nums) 2) nums
    (concat
     (quick-sort (filter #(< % (first nums)) nums))
     (filter #(= % (first nums)) nums)
     (quick-sort (filter #(> % (first nums)) nums)))))

(defn repeat-str-recursive [n s]
  ((defn rec [count list]
     (if (= count 0)
       (clojure.string/join list) 
       (rec (- count 1) (conj list s)))
    ) n []))

(defn repeat-str [n s]
  (apply str (repeat n s)))

(defn repeat-str2 [n s]
  (->> [n s]
       (apply repeat)
       (apply str)))

(defn -main []
   (->>
     '(2 3 1 4 0)
     quick-sort
     println))

(re-str 3 "Hello ")
(->> [4 "H "] 
     (apply repeat) 
     (apply str))
