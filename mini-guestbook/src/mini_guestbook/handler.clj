(ns mini-guestbook.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.core :refer (html)]
            [hiccup.form :as form]
            [hiccup.page :as page]
            [ring.util.anti-forgery :as anti-forgery]
            [ring.util.response :as resp]
            [clojure.java.jdbc :as sql]))

(def h2-db {:dbtype "h2"
            :dbname "./mini_guestbook_h2"})

(defn add-form []
  (form/form-to [:post "/add"]
                (anti-forgery/anti-forgery-field)
                (form/text-area {:row 2 :cols 30} "message") [:br]
                (form/submit-button "Send")))

(defn messages []
  (sql/query h2-db
             "select * from guestbook"))

(defn message-list []
  [:ul
   (map (fn [x] [:li (:message x)])
        (messages))])

(defn index []
  (html
    [:head
     [:title "Guest-book"]
     (page/include-css "/styles.css")]
    [:body
     [:h1 "Guest-book"]
     (add-form)
     [:h2 "Message"]
     (message-list)]))

(defn add [message]
  (println message)
  (sql/insert! h2-db
              :guestbook {:message message})
  (resp/redirect "/"))

(defroutes app-routes
  (GET "/" [] (index))
  (POST "/add" [message] (add message))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
