package com.ankamagames.dofus.network.messages.game.character.creation;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterCreationResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 161;
    private boolean _isInitialized = false;
    private int result = 1;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 161;
    }

    public CharacterCreationResultMessage initCharacterCreationResultMessage(int param1) {
         this.result = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.result = 1;
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
         this.serializeAs_CharacterCreationResultMessage(param1);
    }

    public void serializeAs_CharacterCreationResultMessage(ICustomDataOutput param1) {
         param1.writeByte(this.result);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterCreationResultMessage(param1);
    }

    public void deserializeAs_CharacterCreationResultMessage(ICustomDataInput param1) {
         this._resultFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterCreationResultMessage(param1);
    }

    public void deserializeAsyncAs_CharacterCreationResultMessage(FuncTree param1) {
         param1.addChild(this._resultFunc);
    }

    private void _resultFunc(ICustomDataInput param1) {
         this.result = param1.readByte();
         if(this.result < 0)
         {
            throw new Exception("Forbidden value (" + this.result + ") on element of CharacterCreationResultMessage.result.");
         }
    }

}