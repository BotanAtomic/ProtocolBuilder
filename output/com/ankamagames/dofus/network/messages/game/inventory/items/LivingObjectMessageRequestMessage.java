package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class LivingObjectMessageRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6066;
    private boolean _isInitialized = false;
    private int msgId = 0;
    private Vector<String> parameters;
    private int livingObject = 0;
    private FuncTree _parameterstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6066;
    }

    public LivingObjectMessageRequestMessage initLivingObjectMessageRequestMessage(int param1,Vector<String>  param2,int  param3) {
         this.msgId = param1;
         this.parameters = param2;
         this.livingObject = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.msgId = 0;
         this.parameters = new Vector.<String>();
         this.livingObject = 0;
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
         this.serializeAs_LivingObjectMessageRequestMessage(param1);
    }

    public void serializeAs_LivingObjectMessageRequestMessage(ICustomDataOutput param1) {
         if(this.msgId < 0)
         {
            throw new Exception("Forbidden value (" + this.msgId + ") on element msgId.");
         }
         param1.writeVarShort(this.msgId);
         param1.writeShort(this.parameters.length);
         int _loc2_ = 0;
         while(_loc2_ < this.parameters.length)
         {
            param1.writeUTF(this.parameters[_loc2_]);
            _loc2_++;
         }
         if(this.livingObject < 0)
         {
            throw new Exception("Forbidden value (" + this.livingObject + ") on element livingObject.");
         }
         param1.writeVarInt(this.livingObject);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_LivingObjectMessageRequestMessage(param1);
    }

    public void deserializeAs_LivingObjectMessageRequestMessage(ICustomDataInput param1) {
         String _loc4_ = null;
         this._msgIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUTF();
            this.parameters.push(_loc4_);
            _loc3_++;
         }
         this._livingObjectFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_LivingObjectMessageRequestMessage(param1);
    }

    public void deserializeAsyncAs_LivingObjectMessageRequestMessage(FuncTree param1) {
         param1.addChild(this._msgIdFunc);
         this._parameterstree = param1.addChild(this._parameterstreeFunc);
         param1.addChild(this._livingObjectFunc);
    }

    private void _msgIdFunc(ICustomDataInput param1) {
         this.msgId = param1.readVarUhShort();
         if(this.msgId < 0)
         {
            throw new Exception("Forbidden value (" + this.msgId + ") on element of LivingObjectMessageRequestMessage.msgId.");
         }
    }

    private void _parameterstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._parameterstree.addChild(this._parametersFunc);
            _loc3_++;
         }
    }

    private void _parametersFunc(ICustomDataInput param1) {
         String _loc2_ = param1.readUTF();
         this.parameters.push(_loc2_);
    }

    private void _livingObjectFunc(ICustomDataInput param1) {
         this.livingObject = param1.readVarUhInt();
         if(this.livingObject < 0)
         {
            throw new Exception("Forbidden value (" + this.livingObject + ") on element of LivingObjectMessageRequestMessage.livingObject.");
         }
    }

}