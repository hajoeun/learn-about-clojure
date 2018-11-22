(ns hello.core
  (:gen-class) 
  (:use clojure.string))

(def preset-colors {:springgreen "#00ff7f" :aqua "#00ffff" :blue "#0000ff" :olivedrab "#6b8e23"})
       
(defn -main []
   (->>
     preset-colors
     println))

(defn parse-html-color [color]
  (defn end-parser [hex]
    (println hex))
  (def to-hex [digit]
    (println digit))
  (end-parser
    (if (re-find #"^#" color) 
      (to-hex color)
      (get preset-colors (lower-case color))))
 
