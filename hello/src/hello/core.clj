(ns hello.core
  (:gen-class))

(defn quick-sort [nums]
  (if (< (count nums) 2) nums
    (con`cat
     (quick-sort (filter #(< % (first nums)) nums))
     (filter #(= % (first nums)) nums)
     (quick-sort (filter #(> % (first nums)) nums)))))

;; (defn repeat-str-recursive [n s]
;;  ((defn rec [co li]
;;     (if (= co 0)
;;       (clojure.string/join li) 
;;       (rec (- co 1) (conj list s)))
;;    ) n []))

;; (defn repeat-str [n s]
;;  (apply str (repeat n s)))

;; (defn repeat-str2 [n s]
;;  (->> [n s]
;;       (apply repeat)
;;       (apply str)))

(defn covfefe[tw]
  (if (re-find #"coverage" tw)
    (clojure.string/replace tw #"coverage" "covfefe")
    (str tw " covfefe")))

(defn parse-html-color [color]
  (if (re-find #"^#" color)
    (if 

(defn -main []
   (->>
     '(2 3 1 4 0)
     quick-sort
     println))

;; (re-str 3 "Hello ")
(->> [4 "H "] 
     (apply repeat) 
     (apply str))

(covfefe "coverage")
(covfefe "I have coverage for them")
(covfefe "I dont know")
