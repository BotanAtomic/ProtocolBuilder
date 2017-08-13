package package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class MapFightCountMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 210;
    private boolean _isInitialized = false;
    private int fightCount = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 210;
    }

    public MapFightCountMessage initMapFightCountMessage(int param1) {
         this.fightCount = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fightCount = 0;
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
         this.serializeAs_MapFightCountMessage(param1);
    }

    public void serializeAs_MapFightCountMessage(ICustomDataOutput param1) {
         if(this.fightCount < 0)
            throw new Exception("Forbidden value (" + this.fightCount + ") on element fightCount.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapFightCountMessage(param1);
    }

    public void deserializeAs_MapFightCountMessage(ICustomDataInput param1) {
         this._fightCountFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapFightCountMessage(param1);
    }

    public void deserializeAsyncAs_MapFightCountMessage(FuncTree param1) {
         param1.addChild(this._fightCountFunc);
    }

    private void _fightCountFunc(ICustomDataInput param1) {
         this.fightCount = param1.readVarUhShort();
         if(this.fightCount < 0)
            throw new Exception("Forbidden value (" + this.fightCount + ") on element of MapFightCountMessage.fightCount.");
    }

}