package package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.connection.GameServerInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SelectedServerDataExtendedMessage extends SelectedServerDataMessage implements INetworkMessage {

    private int protocolId = 6469;
    private boolean _isInitialized = false;
    private Vector.<GameServerInformations> servers = ;
    private FuncTree _serverstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6469;
    }

    public SelectedServerDataExtendedMessage initSelectedServerDataExtendedMessage(int param1,String  param2,int  param3,boolean  param4,Vector.<int>  param5,Vector.<GameServerInformations>  param6) {
         super.initSelectedServerDataMessage(param1,param2,param3,param4,param5);
         this.servers = param6;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.servers = new Vector.<GameServerInformations>();
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
         this.serializeAs_SelectedServerDataExtendedMessage(param1);
    }

    public void serializeAs_SelectedServerDataExtendedMessage(ICustomDataOutput param1) {
         super.serializeAs_SelectedServerDataMessage(param1);
         param1.writeShort(this.servers.length);
         int _loc2_ = 0;
         while(_loc2_ < this.servers.length)
            (this.servers[_loc2_] as GameServerInformations).serializeAs_GameServerInformations(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SelectedServerDataExtendedMessage(param1);
    }

    public void deserializeAs_SelectedServerDataExtendedMessage(ICustomDataInput param1) {
         GameServerInformations _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new GameServerInformations();
            _loc4_.deserialize(param1);
            this.servers.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SelectedServerDataExtendedMessage(param1);
    }

    public void deserializeAsyncAs_SelectedServerDataExtendedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._serverstree = param1.addChild(this._serverstreeFunc);
    }

    private void _serverstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._serverstree.addChild(this._serversFunc);
            _loc3_++;
    }

    private void _serversFunc(ICustomDataInput param1) {
         GameServerInformations _loc2_ = new GameServerInformations();
         _loc2_.deserialize(param1);
         this.servers.push(_loc2_);
    }

}