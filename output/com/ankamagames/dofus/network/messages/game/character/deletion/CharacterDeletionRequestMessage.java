package com.ankamagames.dofus.network.messages.game.character.deletion;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterDeletionRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 165;
    private boolean _isInitialized = false;
    private Number characterId = 0;
    private String secretAnswerHash = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 165;
    }

    public CharacterDeletionRequestMessage initCharacterDeletionRequestMessage(Number param1,String  param2) {
         this.characterId = param1;
         this.secretAnswerHash = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.characterId = 0;
         this.secretAnswerHash = "";
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterDeletionRequestMessage(param1);
    }

    public void serializeAs_CharacterDeletionRequestMessage(ICustomDataOutput param1) {
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterId + ") on element characterId.");
         }
         param1.writeVarLong(this.characterId);
         param1.writeUTF(this.secretAnswerHash);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterDeletionRequestMessage(param1);
    }

    public void deserializeAs_CharacterDeletionRequestMessage(ICustomDataInput param1) {
         this._characterIdFunc(param1);
         this._secretAnswerHashFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterDeletionRequestMessage(param1);
    }

    public void deserializeAsyncAs_CharacterDeletionRequestMessage(FuncTree param1) {
         param1.addChild(this._characterIdFunc);
         param1.addChild(this._secretAnswerHashFunc);
    }

    private void _characterIdFunc(ICustomDataInput param1) {
         this.characterId = param1.readVarUhLong();
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterId + ") on element of CharacterDeletionRequestMessage.characterId.");
         }
    }

    private void _secretAnswerHashFunc(ICustomDataInput param1) {
         this.secretAnswerHash = param1.readUTF();
    }

}