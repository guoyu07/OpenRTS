/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.actorDrawing;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.LoopMode;
import com.jme3.scene.Spatial;
import model.battlefield.actors.AnimationActor;
import static model.battlefield.actors.AnimationActor.Cycle.Cycle;
import static model.battlefield.actors.AnimationActor.Cycle.Loop;
import static model.battlefield.actors.AnimationActor.Cycle.Once;

/**
 *
 * @author Benoît
 */
public class AnimationActorDrawer {
    protected void draw(AnimationActor actor){
        Spatial s = actor.getParentModelActor().viewElements.spatial;
        AnimChannel channel = s.getControl(AnimControl.class).getChannel(0);
        channel.setAnim(actor.animName);
        switch (actor.cycle){
            case Once : channel.setLoopMode(LoopMode.DontLoop); break;
            case Loop : channel.setLoopMode(LoopMode.Loop); break;
            case Cycle : channel.setLoopMode(LoopMode.Cycle); break;
        }
        channel.setSpeed((float)actor.speed);
        
        actor.stopActing();
    }

}
