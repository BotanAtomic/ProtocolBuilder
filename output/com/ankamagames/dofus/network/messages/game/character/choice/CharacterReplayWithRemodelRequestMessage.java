package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.dofus.network.messages.game.character.replay.CharacterReplayRequestMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.RemodelingInformation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterReplayWithRemodelRequestMessage extends CharacterReplayRequestMessage implements INetworkMessage {

    private int protocolId = 6551;
    private boolean _isInitialized = false;
    private RemodelingInformation remodel;
    private FuncTree _remodeltree;


    public void serialize(ICustomDataOutput param1) {
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterId + ") on element characterId.");
         }
         param1.writeVarLong(this.characterId);
         this.remodel.serializeAs_RemodelingInformation(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterReplayRequestMessage(param1);
         this.remodel = new RemodelingInformation();
         this.remodel.deserialize(param1);
    }

}