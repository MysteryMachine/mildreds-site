(ns mildreds-site.core
  (:require [reagent.core :refer [atom] :as reagent]))
(enable-console-print!)

(defonce app-state (atom {:text "Hello world!"}))

(def pages
  {:home   "/"
   :wip    "/work-in-progress"
   :food   "/food"
   :music  "/music"
   :travel "/travel"})

(def nav-links
  {"NEWEST"  :home
   "FASHION" :wip
   "FOOD"    :food
   "MUSIC"   :music
   "TRAVEL"  :travel})

(defn header []
  [:div#header
   [:div.box
    [:h1.title "MY FAVORITE THINGS"]
    [:div.divider]
    [:h2.subtitle "Look at them"]]])
 
(defn
  render-nav-link
  [nav-link] ;; ["sal" :wip] -> vector
  (let [nav-key (first nav-link) ;; v-> "sal", t-> string
         url-key (second nav-link) ;; v-> :wip, t-> keyword
        url (get pages url-key) ;; v-> "/work-in-progress", t-> string
        ]
    [:span  ;; <span>
     [:a.nav-link ;; <a class="nav-link"
      {:href url} ;;    href="/work-in-progress">
      nav-key]])) ;;    sal </a>
            ;;  </span>

(defn nav []
  [:div#nav (map render-nav-link nav-links)]) ;; call render-nav-link on every key value pair
  ;; in nav-links

(defn body [])

(defn app []
  [:div#favthings
   [header]
   [nav] ;; calls nav function and puts it in our app
   [body]])

(reagent/render-component [app] (js/document.getElementById "app"))

(defn on-js-reload [])
