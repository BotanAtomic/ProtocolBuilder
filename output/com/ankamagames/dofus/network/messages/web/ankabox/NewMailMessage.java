package com.ankamagames.dofus.network.messages.web.ankabox;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class NewMailMessage extends MailStatusMessage implements INetworkMessage {

    private int protocolId = 6292;
    private boolean _isInitialized = false;
    private Vector<uint> sendersAccountId;
    private FuncTree _sendersAccountIdtree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6292;
    }

    public NewMailMessage initNewMailMessage(int param1,int  param2,Vector<uint>  param3) {
         super.initMailStatusMessage(param1,param2);
         this.sendersAccountId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.sendersAccountId = new Vector.<uint>();
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
         this.serializeAs_NewMailMessage(param1);
    }

    public void serializeAs_NewMailMessage(ICustomDataOutput param1) {
         super.serializeAs_MailStatusMessage(param1);
         param1.writeShort(this.sendersAccountId.length);
         int _loc2_ = 0;
         while(_loc2_ < this.sendersAccountId.length)
         {
            if(this.sendersAccountId[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.sendersAccountId[_loc2_] + ") on element 1 (starting at 1) of sendersAccountId.");
            }
            param1.writeInt(this.sendersAccountId[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NewMailMessage(param1);
    }

    public void deserializeAs_NewMailMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readInt();
            if(_loc4_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of sendersAccountId.");
            }
            this.sendersAccountId.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_NewMailMessage(param1);
    }

    public void deserializeAsyncAs_NewMailMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._sendersAccountIdtree = param1.addChild(this._sendersAccountIdtreeFunc);
    }

    private void _sendersAccountIdtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._sendersAccountIdtree.addChild(this._sendersAccountIdFunc);
            _loc3_++;
         }
    }

    private void _sendersAccountIdFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of sendersAccountId.");
         }
         this.sendersAccountId.push(_loc2_);
    }

}