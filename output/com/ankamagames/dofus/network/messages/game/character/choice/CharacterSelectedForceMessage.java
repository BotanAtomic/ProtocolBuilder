package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterSelectedForceMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6068;
    private boolean _isInitialized = false;
    private int id = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6068;
    }

    public CharacterSelectedForceMessage initCharacterSelectedForceMessage(int param1) {
         this.id = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.id = 0;
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
         this.serializeAs_CharacterSelectedForceMessage(param1);
    }

    public void serializeAs_CharacterSelectedForceMessage(ICustomDataOutput param1) {
         if(this.id < 1 || this.id > 2147483647)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeInt(this.id);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterSelectedForceMessage(param1);
    }

    public void deserializeAs_CharacterSelectedForceMessage(ICustomDataInput param1) {
         this._idFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterSelectedForceMessage(param1);
    }

    public void deserializeAsyncAs_CharacterSelectedForceMessage(FuncTree param1) {
         param1.addChild(this._idFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readInt();
         if(this.id < 1 || this.id > 2147483647)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of CharacterSelectedForceMessage.id.");
         }
    }

}