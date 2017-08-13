package com.ankamagames.dofus.network.messages.game.interactive.zaap;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ZaapListMessage extends TeleportDestinationsListMessage implements INetworkMessage {

    private int protocolId = 1604;
    private boolean _isInitialized = false;
    private int spawnMapId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 1604;
    }

    public ZaapListMessage initZaapListMessage(int param1,Vector<uint>  param2,Vector<uint>  param3,Vector<uint>  param4,Vector<uint>  param5,int  param6) {
         super.initTeleportDestinationsListMessage(param1,param2,param3,param4,param5);
         this.spawnMapId = param6;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.spawnMapId = 0;
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
         this.serializeAs_ZaapListMessage(param1);
    }

    public void serializeAs_ZaapListMessage(ICustomDataOutput param1) {
         super.serializeAs_TeleportDestinationsListMessage(param1);
         if(this.spawnMapId < 0)
         {
            throw new Exception("Forbidden value (" + this.spawnMapId + ") on element spawnMapId.");
         }
         param1.writeInt(this.spawnMapId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ZaapListMessage(param1);
    }

    public void deserializeAs_ZaapListMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._spawnMapIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ZaapListMessage(param1);
    }

    public void deserializeAsyncAs_ZaapListMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._spawnMapIdFunc);
    }

    private void _spawnMapIdFunc(ICustomDataInput param1) {
         this.spawnMapId = param1.readInt();
         if(this.spawnMapId < 0)
         {
            throw new Exception("Forbidden value (" + this.spawnMapId + ") on element of ZaapListMessage.spawnMapId.");
         }
    }

}