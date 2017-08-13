package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightTriggerEffectMessage extends GameActionFightDispellEffectMessage implements INetworkMessage {

    private int protocolId = 6147;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameActionFightDispellEffectMessage(param1);
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