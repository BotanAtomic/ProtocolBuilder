package com.ankamagames.dofus.network.messages.connection;

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

public class SelectedServerDataMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 42;
    private boolean _isInitialized = false;
    private int serverId = 0;
    private String address = "";
    private int port = 0;
    private boolean canCreateNewCharacter = false;
    private Vector<int> ticket;
    private FuncTree _tickettree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 42;
    }

    public SelectedServerDataMessage initSelectedServerDataMessage(int param1,String  param2,int  param3,boolean  param4,Vector<int>  param5) {
         this.serverId = param1;
         this.address = param2;
         this.port = param3;
         this.canCreateNewCharacter = param4;
         this.ticket = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.serverId = 0;
         this.address = "";
         this.port = 0;
         this.canCreateNewCharacter = false;
         this.ticket = new Vector.<int>();
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
         this.serializeAs_SelectedServerDataMessage(param1);
    }

    public void serializeAs_SelectedServerDataMessage(ICustomDataOutput param1) {
         if(this.serverId < 0)
         {
            throw new Exception("Forbidden value (" + this.serverId + ") on element serverId.");
         }
         param1.writeVarShort(this.serverId);
         param1.writeUTF(this.address);
         if(this.port < 0 || this.port > 65535)
         {
            throw new Exception("Forbidden value (" + this.port + ") on element port.");
         }
         param1.writeShort(this.port);
         param1.writeBoolean(this.canCreateNewCharacter);
         param1.writeVarInt(this.ticket.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ticket.length)
         {
            param1.writeByte(this.ticket[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SelectedServerDataMessage(param1);
    }

    public void deserializeAs_SelectedServerDataMessage(ICustomDataInput param1) {
         * _loc4_ = 0;
         this._serverIdFunc(param1);
         this._addressFunc(param1);
         this._portFunc(param1);
         this._canCreateNewCharacterFunc(param1);
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readByte();
            this.ticket.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SelectedServerDataMessage(param1);
    }

    public void deserializeAsyncAs_SelectedServerDataMessage(FuncTree param1) {
         param1.addChild(this._serverIdFunc);
         param1.addChild(this._addressFunc);
         param1.addChild(this._portFunc);
         param1.addChild(this._canCreateNewCharacterFunc);
         this._tickettree = param1.addChild(this._tickettreeFunc);
    }

    private void _serverIdFunc(ICustomDataInput param1) {
         this.serverId = param1.readVarUhShort();
         if(this.serverId < 0)
         {
            throw new Exception("Forbidden value (" + this.serverId + ") on element of SelectedServerDataMessage.serverId.");
         }
    }

    private void _addressFunc(ICustomDataInput param1) {
         this.address = param1.readUTF();
    }

    private void _portFunc(ICustomDataInput param1) {
         this.port = param1.readUnsignedShort();
         if(this.port < 0 || this.port > 65535)
         {
            throw new Exception("Forbidden value (" + this.port + ") on element of SelectedServerDataMessage.port.");
         }
    }

    private void _canCreateNewCharacterFunc(ICustomDataInput param1) {
         this.canCreateNewCharacter = param1.readBoolean();
    }

    private void _tickettreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._tickettree.addChild(this._ticketFunc);
            _loc3_++;
         }
    }

    private void _ticketFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.ticket.push(_loc2_);
    }

}