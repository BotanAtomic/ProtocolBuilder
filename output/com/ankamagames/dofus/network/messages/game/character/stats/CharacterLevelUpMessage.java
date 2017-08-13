package package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterLevelUpMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5670;
    private boolean _isInitialized = false;
    private int newLevel = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5670;
    }

    public CharacterLevelUpMessage initCharacterLevelUpMessage(int param1) {
         this.newLevel = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.newLevel = 0;
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
         this.serializeAs_CharacterLevelUpMessage(param1);
    }

    public void serializeAs_CharacterLevelUpMessage(ICustomDataOutput param1) {
         if(this.newLevel < 2 || this.newLevel > 206)
            throw new Exception("Forbidden value (" + this.newLevel + ") on element newLevel.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterLevelUpMessage(param1);
    }

    public void deserializeAs_CharacterLevelUpMessage(ICustomDataInput param1) {
         this._newLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterLevelUpMessage(param1);
    }

    public void deserializeAsyncAs_CharacterLevelUpMessage(FuncTree param1) {
         param1.addChild(this._newLevelFunc);
    }

    private void _newLevelFunc(ICustomDataInput param1) {
         this.newLevel = param1.readUnsignedByte();
         if(this.newLevel < 2 || this.newLevel > 206)
            throw new Exception("Forbidden value (" + this.newLevel + ") on element of CharacterLevelUpMessage.newLevel.");
    }

}