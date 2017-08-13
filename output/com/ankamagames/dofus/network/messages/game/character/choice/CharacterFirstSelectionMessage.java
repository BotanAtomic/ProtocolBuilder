package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterFirstSelectionMessage extends CharacterSelectionMessage implements INetworkMessage {

    private int protocolId = 6084;
    private boolean _isInitialized = false;
    private boolean doTutorial = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarLong(this.id);
         param1.writeBoolean(this.doTutorial);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterSelectionMessage(param1);
         this.doTutorial = param1.readBoolean();
    }

}