package com.sound

import java.io.{BufferedInputStream, InputStream}
import javax.sound.sampled.AudioSystem

sealed trait SoundEffect {
    def play
}
case object PlayerShooting extends SoundEffect {
    private val bufferedInput = new BufferedInputStream(this.getClass.getResourceAsStream("/shoot.wav"))
    private val audioInputStream = AudioSystem.getAudioInputStream(bufferedInput)
    private val clip   = AudioSystem.getClip()
    clip.open(audioInputStream)

    override def play: Unit = {
        if(clip.isRunning)
            clip.stop()
        clip.setFramePosition(0)
        clip.start()
    }

}