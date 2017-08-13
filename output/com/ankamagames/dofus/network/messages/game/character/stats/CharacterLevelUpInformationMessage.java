package package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterLevelUpInformationMessage extends CharacterLevelUpMessage implements INetworkMessage {

    private int protocolId = 6076;
    private boolean _isInitialized = false;
    private String name = "";
    private Number id = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6076;
    }

    public CharacterLevelUpInformationMessage initCharacterLevelUpInformationMessage(int param1,String  param2,Number  param3) {
         super.initCharacterLevelUpMessage(param1);
         this.name = param2;
         this.id = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.name = "";
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
         this.serializeAs_CharacterLevelUpInformationMessage(param1);
    }

    public void serializeAs_CharacterLevelUpInformationMessage(ICustomDataOutput param1) {
         super.serializeAs_CharacterLevelUpMessage(param1);
         param1.writeUTF(this.name);
         if(this.id < 0 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterLevelUpInformationMessage(param1);
    }

    public void deserializeAs_CharacterLevelUpInformationMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._nameFunc(param1);
         this._idFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterLevelUpInformationMessage(param1);
    }

    public void deserializeAsyncAs_CharacterLevelUpInformationMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nameFunc);
         param1.addChild(this._idFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element of CharacterLevelUpInformationMessage.id.");
    }

}