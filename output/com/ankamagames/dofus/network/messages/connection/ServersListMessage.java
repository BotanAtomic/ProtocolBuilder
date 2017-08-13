package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.connection.GameServerInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ServersListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 30;
    private boolean _isInitialized = false;
    private Vector<GameServerInformations> servers;
    private int alreadyConnectedToServerId = 0;
    private boolean canCreateNewCharacter = false;
    private FuncTree _serverstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 30;
    }

    public ServersListMessage initServersListMessage(Vector<GameServerInformations> param1,int  param2,boolean  param3) {
         this.servers = param1;
         this.alreadyConnectedToServerId = param2;
         this.canCreateNewCharacter = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.servers = new Vector.<GameServerInformations>();
         this.alreadyConnectedToServerId = 0;
         this.canCreateNewCharacter = false;
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
         this.serializeAs_ServersListMessage(param1);
    }

    public void serializeAs_ServersListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.servers.length);
         int _loc2_ = 0;
         while(_loc2_ < this.servers.length)
         {
            (this.servers[_loc2_] as GameServerInformations).serializeAs_GameServerInformations(param1);
            _loc2_++;
         }
         if(this.alreadyConnectedToServerId < 0)
         {
            throw new Exception("Forbidden value (" + this.alreadyConnectedToServerId + ") on element alreadyConnectedToServerId.");
         }
         param1.writeVarShort(this.alreadyConnectedToServerId);
         param1.writeBoolean(this.canCreateNewCharacter);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ServersListMessage(param1);
    }

    public void deserializeAs_ServersListMessage(ICustomDataInput param1) {
         GameServerInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new GameServerInformations();
            _loc4_.deserialize(param1);
            this.servers.push(_loc4_);
            _loc3_++;
         }
         this._alreadyConnectedToServerIdFunc(param1);
         this._canCreateNewCharacterFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ServersListMessage(param1);
    }

    public void deserializeAsyncAs_ServersListMessage(FuncTree param1) {
         this._serverstree = param1.addChild(this._serverstreeFunc);
         param1.addChild(this._alreadyConnectedToServerIdFunc);
         param1.addChild(this._canCreateNewCharacterFunc);
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
         GameServerInformations _loc2_ = new GameServerInformations();
         _loc2_.deserialize(param1);
         this.servers.push(_loc2_);
    }

    private void _alreadyConnectedToServerIdFunc(ICustomDataInput param1) {
         this.alreadyConnectedToServerId = param1.readVarUhShort();
         if(this.alreadyConnectedToServerId < 0)
         {
            throw new Exception("Forbidden value (" + this.alreadyConnectedToServerId + ") on element of ServersListMessage.alreadyConnectedToServerId.");
         }
    }

    private void _canCreateNewCharacterFunc(ICustomDataInput param1) {
         this.canCreateNewCharacter = param1.readBoolean();
    }

}