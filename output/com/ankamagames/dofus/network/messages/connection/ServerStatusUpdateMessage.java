package package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.connection.GameServerInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ServerStatusUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 50;
    private boolean _isInitialized = false;
    private GameServerInformations server = ;
    private FuncTree _servertree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 50;
    }

    public ServerStatusUpdateMessage initServerStatusUpdateMessage(GameServerInformations param1) {
         this.server = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.server = new GameServerInformations();
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
         this.serializeAs_ServerStatusUpdateMessage(param1);
    }

    public void serializeAs_ServerStatusUpdateMessage(ICustomDataOutput param1) {
         this.server.serializeAs_GameServerInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ServerStatusUpdateMessage(param1);
    }

    public void deserializeAs_ServerStatusUpdateMessage(ICustomDataInput param1) {
         this.server = new GameServerInformations();
         this.server.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ServerStatusUpdateMessage(param1);
    }

    public void deserializeAsyncAs_ServerStatusUpdateMessage(FuncTree param1) {
         this._servertree = param1.addChild(this._servertreeFunc);
    }

    private void _servertreeFunc(ICustomDataInput param1) {
         this.server = new GameServerInformations();
         this.server.deserializeAsync(this._servertree);
    }

}