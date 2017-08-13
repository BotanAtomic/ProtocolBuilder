package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockContentInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GuildInformationsPaddocksMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5959;
    private boolean _isInitialized = false;
    private int nbPaddockMax = 0;
    private Vector.<PaddockContentInformations> paddocksInformations = ;
    private FuncTree _paddocksInformationstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5959;
    }

    public GuildInformationsPaddocksMessage initGuildInformationsPaddocksMessage(int param1,Vector.<PaddockContentInformations>  param2) {
         this.nbPaddockMax = param1;
         this.paddocksInformations = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.nbPaddockMax = 0;
         this.paddocksInformations = new Vector.<PaddockContentInformations>();
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
         this.serializeAs_GuildInformationsPaddocksMessage(param1);
    }

    public void serializeAs_GuildInformationsPaddocksMessage(ICustomDataOutput param1) {
         if(this.nbPaddockMax < 0)
            throw new Exception("Forbidden value (" + this.nbPaddockMax + ") on element nbPaddockMax.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInformationsPaddocksMessage(param1);
    }

    public void deserializeAs_GuildInformationsPaddocksMessage(ICustomDataInput param1) {
         PaddockContentInformations _loc4_ = null;
         this._nbPaddockMaxFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new PaddockContentInformations();
            _loc4_.deserialize(param1);
            this.paddocksInformations.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInformationsPaddocksMessage(param1);
    }

    public void deserializeAsyncAs_GuildInformationsPaddocksMessage(FuncTree param1) {
         param1.addChild(this._nbPaddockMaxFunc);
         this._paddocksInformationstree = param1.addChild(this._paddocksInformationstreeFunc);
    }

    private void _nbPaddockMaxFunc(ICustomDataInput param1) {
         this.nbPaddockMax = param1.readByte();
         if(this.nbPaddockMax < 0)
            throw new Exception("Forbidden value (" + this.nbPaddockMax + ") on element of GuildInformationsPaddocksMessage.nbPaddockMax.");
    }

    private void _paddocksInformationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._paddocksInformationstree.addChild(this._paddocksInformationsFunc);
            _loc3_++;
    }

    private void _paddocksInformationsFunc(ICustomDataInput param1) {
         PaddockContentInformations _loc2_ = new PaddockContentInformations();
         _loc2_.deserialize(param1);
         this.paddocksInformations.push(_loc2_);
    }

}