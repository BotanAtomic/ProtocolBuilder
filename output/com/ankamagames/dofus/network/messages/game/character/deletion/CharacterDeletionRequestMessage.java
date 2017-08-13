package com.ankamagames.dofus.network.messages.game.character.deletion;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterDeletionRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 165;
    private boolean _isInitialized = false;
    private Number characterId = 0;
    private String secretAnswerHash = "";


    public void serialize(ICustomDataOutput param1) {
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterId + ") on element characterId.");
         }
         param1.writeVarLong(this.characterId);
         param1.writeUTF(this.secretAnswerHash);
    }

    public void deserialize(ICustomDataInput param1) {
         this.characterId = param1.readVarUhLong();
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterId + ") on element of CharacterDeletionRequestMessage.characterId.");
         }
         this.secretAnswerHash = param1.readUTF();
    }

}