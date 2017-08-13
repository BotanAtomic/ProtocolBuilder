package package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class JobMultiCraftAvailableSkillsMessage extends JobAllowMultiCraftRequestMessage implements INetworkMessage {

    private int protocolId = 5747;
    private boolean _isInitialized = false;
    private Number playerId = 0;
    private Vector.<uint> skills = ;
    private FuncTree _skillstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5747;
    }

    public JobMultiCraftAvailableSkillsMessage initJobMultiCraftAvailableSkillsMessage(boolean param1,Number  param2,Vector.<uint>  param3) {
         super.initJobAllowMultiCraftRequestMessage(param1);
         this.playerId = param2;
         this.skills = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.playerId = 0;
         this.skills = new Vector.<uint>();
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
         this.serializeAs_JobMultiCraftAvailableSkillsMessage(param1);
    }

    public void serializeAs_JobMultiCraftAvailableSkillsMessage(ICustomDataOutput param1) {
         super.serializeAs_JobAllowMultiCraftRequestMessage(param1);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobMultiCraftAvailableSkillsMessage(param1);
    }

    public void deserializeAs_JobMultiCraftAvailableSkillsMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         super.deserialize(param1);
         this._playerIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of skills.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobMultiCraftAvailableSkillsMessage(param1);
    }

    public void deserializeAsyncAs_JobMultiCraftAvailableSkillsMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._playerIdFunc);
         this._skillstree = param1.addChild(this._skillstreeFunc);
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.playerId + ") on element of JobMultiCraftAvailableSkillsMessage.playerId.");
    }

    private void _skillstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._skillstree.addChild(this._skillsFunc);
            _loc3_++;
    }

    private void _skillsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of skills.");
    }

}