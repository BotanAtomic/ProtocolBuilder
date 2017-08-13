package com.ankamagames.dofus.network.messages.connection.search;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class AcquaintanceServerListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6142;
    private boolean _isInitialized = false;
    private Vector<uint> servers;
    private FuncTree _serverstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6142;
    }

    public AcquaintanceServerListMessage initAcquaintanceServerListMessage(Vector<uint> param1) {
         this.servers = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.servers = new Vector.<uint>();
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
         this.serializeAs_AcquaintanceServerListMessage(param1);
    }

    public void serializeAs_AcquaintanceServerListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.servers.length);
         int _loc2_ = 0;
         while(_loc2_ < this.servers.length)
         {
            if(this.servers[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.servers[_loc2_] + ") on element 1 (starting at 1) of servers.");
            }
            param1.writeVarShort(this.servers[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AcquaintanceServerListMessage(param1);
    }

    public void deserializeAs_AcquaintanceServerListMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of servers.");
            }
            this.servers.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AcquaintanceServerListMessage(param1);
    }

    public void deserializeAsyncAs_AcquaintanceServerListMessage(FuncTree param1) {
         this._serverstree = param1.addChild(this._serverstreeFunc);
    }

    private void _serverstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._serverstree.addChild(this._serversFunc);
            _loc3_++;
         }
    }

    private void _serversFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of servers.");
         }
         this.servers.push(_loc2_);
    }

}