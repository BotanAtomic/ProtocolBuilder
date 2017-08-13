package package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class EntityTalkMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6110;
    private boolean _isInitialized = false;
    private Number entityId = 0;
    private int textId = 0;
    private Vector.<String> parameters = ;
    private FuncTree _parameterstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6110;
    }

    public EntityTalkMessage initEntityTalkMessage(Number param1,int  param2,Vector.<String>  param3) {
         this.entityId = param1;
         this.textId = param2;
         this.parameters = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.entityId = 0;
         this.textId = 0;
         this.parameters = new Vector.<String>();
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
         this.serializeAs_EntityTalkMessage(param1);
    }

    public void serializeAs_EntityTalkMessage(ICustomDataOutput param1) {
         if(this.entityId < -9.007199254740992E15 || this.entityId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.entityId + ") on element entityId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_EntityTalkMessage(param1);
    }

    public void deserializeAs_EntityTalkMessage(ICustomDataInput param1) {
         String _loc4_ = null;
         this._entityIdFunc(param1);
         this._textIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUTF();
            this.parameters.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_EntityTalkMessage(param1);
    }

    public void deserializeAsyncAs_EntityTalkMessage(FuncTree param1) {
         param1.addChild(this._entityIdFunc);
         param1.addChild(this._textIdFunc);
         this._parameterstree = param1.addChild(this._parameterstreeFunc);
    }

    private void _entityIdFunc(ICustomDataInput param1) {
         this.entityId = param1.readDouble();
         if(this.entityId < -9.007199254740992E15 || this.entityId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.entityId + ") on element of EntityTalkMessage.entityId.");
    }

    private void _textIdFunc(ICustomDataInput param1) {
         this.textId = param1.readVarUhShort();
         if(this.textId < 0)
            throw new Exception("Forbidden value (" + this.textId + ") on element of EntityTalkMessage.textId.");
    }

    private void _parameterstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._parameterstree.addChild(this._parametersFunc);
            _loc3_++;
    }

    private void _parametersFunc(ICustomDataInput param1) {
         String _loc2_ = param1.readUTF();
         this.parameters.push(_loc2_);
    }

}