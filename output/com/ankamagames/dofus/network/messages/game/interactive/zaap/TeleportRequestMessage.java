package package com.ankamagames.dofus.network.messages.game.interactive.zaap;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TeleportRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5961;
    private boolean _isInitialized = false;
    private int teleporterType = 0;
    private int mapId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5961;
    }

    public TeleportRequestMessage initTeleportRequestMessage(int param1,int  param2) {
         this.teleporterType = param1;
         this.mapId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.teleporterType = 0;
         this.mapId = 0;
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
         this.serializeAs_TeleportRequestMessage(param1);
    }

    public void serializeAs_TeleportRequestMessage(ICustomDataOutput param1) {
         param1.writeByte(this.teleporterType);
         if(this.mapId < 0)
            throw new Exception("Forbidden value (" + this.mapId + ") on element mapId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TeleportRequestMessage(param1);
    }

    public void deserializeAs_TeleportRequestMessage(ICustomDataInput param1) {
         this._teleporterTypeFunc(param1);
         this._mapIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TeleportRequestMessage(param1);
    }

    public void deserializeAsyncAs_TeleportRequestMessage(FuncTree param1) {
         param1.addChild(this._teleporterTypeFunc);
         param1.addChild(this._mapIdFunc);
    }

    private void _teleporterTypeFunc(ICustomDataInput param1) {
         this.teleporterType = param1.readByte();
         if(this.teleporterType < 0)
            throw new Exception("Forbidden value (" + this.teleporterType + ") on element of TeleportRequestMessage.teleporterType.");
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
         if(this.mapId < 0)
            throw new Exception("Forbidden value (" + this.mapId + ") on element of TeleportRequestMessage.mapId.");
    }

}