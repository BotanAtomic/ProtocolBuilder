package package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TopTaxCollectorListMessage extends AbstractTaxCollectorListMessage implements INetworkMessage {

    private int protocolId = 6565;
    private boolean _isInitialized = false;
    private boolean isDungeon = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6565;
    }

    public TopTaxCollectorListMessage initTopTaxCollectorListMessage(Vector.<TaxCollectorInformations> param1,boolean  param2) {
         super.initAbstractTaxCollectorListMessage(param1);
         this.isDungeon = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.isDungeon = false;
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
         this.serializeAs_TopTaxCollectorListMessage(param1);
    }

    public void serializeAs_TopTaxCollectorListMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractTaxCollectorListMessage(param1);
         param1.writeBoolean(this.isDungeon);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TopTaxCollectorListMessage(param1);
    }

    public void deserializeAs_TopTaxCollectorListMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._isDungeonFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TopTaxCollectorListMessage(param1);
    }

    public void deserializeAsyncAs_TopTaxCollectorListMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._isDungeonFunc);
    }

    private void _isDungeonFunc(ICustomDataInput param1) {
         this.isDungeon = param1.readBoolean();
    }

}