package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorFightersInformation;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class TaxCollectorListMessage extends Abstract {

    private int protocolId = 5930;
    private boolean _isInitialized = false;
    private int nbcollectorMax = 0;
    private Vector<TaxCollectorFightersInformation> fightersInformations;
    private FuncTree _fightersInformationstree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5930;
    }

    public TaxCollectorListMessage initTaxCollectorListMessage(Vector<TaxCollectorInformations> param1,int  param2,Vector<TaxCollectorFightersInformation>  param3) {
         super.initAbstractTaxCollectorListMessage(param1);
         this.nbcollectorMax = param2;
         this.fightersInformations = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.nbcollectorMax = 0;
         this.fightersInformations = new Vector.<TaxCollectorFightersInformation>();
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
         this.serializeAs_TaxCollectorListMessage(param1);
    }

    public void serializeAs_TaxCollectorListMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractTaxCollectorListMessage(param1);
         if(this.nbcollectorMax < 0)
         {
            throw new Exception("Forbidden value (" + this.nbcollectorMax + ") on element nbcollectorMax.");
         }
         param1.writeByte(this.nbcollectorMax);
         param1.writeShort(this.fightersInformations.length);
         int _loc2_ = 0;
         while(_loc2_ < this.fightersInformations.length)
         {
            (this.fightersInformations[_loc2_] as TaxCollectorFightersInformation).serializeAs_TaxCollectorFightersInformation(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorListMessage(param1);
    }

    public void deserializeAs_TaxCollectorListMessage(ICustomDataInput param1) {
         TaxCollectorFightersInformation _loc4_ = null;
         super.deserialize(param1);
         this._nbcollectorMaxFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new TaxCollectorFightersInformation();
            _loc4_.deserialize(param1);
            this.fightersInformations.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorListMessage(param1);
    }

    public void deserializeAsyncAs_TaxCollectorListMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nbcollectorMaxFunc);
         this._fightersInformationstree = param1.addChild(this._fightersInformationstreeFunc);
    }

    private void _nbcollectorMaxFunc(ICustomDataInput param1) {
         this.nbcollectorMax = param1.readByte();
         if(this.nbcollectorMax < 0)
         {
            throw new Exception("Forbidden value (" + this.nbcollectorMax + ") on element of TaxCollectorListMessage.nbcollectorMax.");
         }
    }

    private void _fightersInformationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._fightersInformationstree.addChild(this._fightersInformationsFunc);
            _loc3_++;
         }
    }

    private void _fightersInformationsFunc(ICustomDataInput param1) {
         TaxCollectorFightersInformation _loc2_ = new TaxCollectorFightersInformation();
         _loc2_.deserialize(param1);
         this.fightersInformations.push(_loc2_);
    }

}