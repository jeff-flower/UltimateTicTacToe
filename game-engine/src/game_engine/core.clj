(ns game-engine.core
  (:require [clojure.core.async
             :as a
             :refer [>! <! >!! <!! go chan buffer close!]]
            [game-engine.engine.engine :as engine]
            [game-engine.basicbot.bot :as basicbot]
            [game-engine.rulesbot.bot :as rulesbot])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [engine-channel (chan)
        bot1-channel (chan)
        bot2-channel (chan)]
    (basicbot/read-input bot1-channel engine-channel)
    (rulesbot/read-input bot2-channel engine-channel)
    (engine/run-game engine-channel bot1-channel bot2-channel)))
