package package com.ankamagames.dofus.network.messages.game.idol;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.idol.Idol;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class IdolFightPreparationUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6586;
    private boolean _isInitialized = false;
    private int idolSource = 0;
    private Vector.<Idol> idols = ;
    private FuncTree _idolstree = ;
    private int _loc2_ = 0;
    private Idol _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private Idol _loc3_ = ProtocolTypeManager.getInstance(Idol,_loc2_);


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6586;
    }

    public IdolFightPreparationUpdateMessage initIdolFightPreparationUpdateMessage(int param1,Vector.<Idol>  param2) {
         this.idolSource = param1;
         this.idols = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.idolSource = 0;
         this.idols = new Vector.<Idol>();
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
         this.serializeAs_IdolFightPreparationUpdateMessage(param1);
    }

    public void serializeAs_IdolFightPreparationUpdateMessage(ICustomDataOutput param1) {
         param1.writeByte(this.idolSource);
         param1.writeShort(this.idols.length);
         int _loc2_ = 0;
         while(_loc2_ < this.idols.length)
            param1.writeShort((this.idols[_loc2_] as Idol).getTypeId());
            (this.idols[_loc2_] as Idol).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdolFightPreparationUpdateMessage(param1);
    }

    public void deserializeAs_IdolFightPreparationUpdateMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         Idol _loc5_ = null;
         this._idolSourceFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(Idol,_loc4_);
            _loc5_.deserialize(param1);
            this.idols.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdolFightPreparationUpdateMessage(param1);
    }

    public void deserializeAsyncAs_IdolFightPreparationUpdateMessage(FuncTree param1) {
         param1.addChild(this._idolSourceFunc);
         this._idolstree = param1.addChild(this._idolstreeFunc);
    }

    private void _idolSourceFunc(ICustomDataInput param1) {
         this.idolSource = param1.readByte();
         if(this.idolSource < 0)
            throw new Exception("Forbidden value (" + this.idolSource + ") on element of IdolFightPreparationUpdateMessage.idolSource.");
    }

    private void _idolstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._idolstree.addChild(this._idolsFunc);
            _loc3_++;
    }

    private void _idolsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         Idol _loc3_ = ProtocolTypeManager.getInstance(Idol,_loc2_);
         _loc3_.deserialize(param1);
         this.idols.push(_loc3_);
    }

}