package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameActionFightDispellEffectMessage extends GameActionFightDispellMessage implements INetworkMessage {

    private int protocolId = 6113;
    private boolean _isInitialized = false;
    private int boostUID = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.boostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.boostUID + ") on element boostUID.");
         }
         param1.writeInt(this.boostUID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightDispellMessage(param1);
         this.boostUID = param1.readInt();
         if(this.boostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.boostUID + ") on element of GameActionFightDispellEffectMessage.boostUID.");
         }
    }

}