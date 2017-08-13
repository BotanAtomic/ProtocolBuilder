package package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.HavenBagFurnitureInformation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HavenBagFurnituresMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6634;
    private boolean _isInitialized = false;
    private Vector.<HavenBagFurnitureInformation> furnituresInfos = ;
    private FuncTree _furnituresInfostree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6634;
    }

    public HavenBagFurnituresMessage initHavenBagFurnituresMessage(Vector.<HavenBagFurnitureInformation> param1) {
         this.furnituresInfos = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.furnituresInfos = new Vector.<HavenBagFurnitureInformation>();
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
         this.serializeAs_HavenBagFurnituresMessage(param1);
    }

    public void serializeAs_HavenBagFurnituresMessage(ICustomDataOutput param1) {
         param1.writeShort(this.furnituresInfos.length);
         int _loc2_ = 0;
         while(_loc2_ < this.furnituresInfos.length)
            (this.furnituresInfos[_loc2_] as HavenBagFurnitureInformation).serializeAs_HavenBagFurnitureInformation(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HavenBagFurnituresMessage(param1);
    }

    public void deserializeAs_HavenBagFurnituresMessage(ICustomDataInput param1) {
         HavenBagFurnitureInformation _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new HavenBagFurnitureInformation();
            _loc4_.deserialize(param1);
            this.furnituresInfos.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HavenBagFurnituresMessage(param1);
    }

    public void deserializeAsyncAs_HavenBagFurnituresMessage(FuncTree param1) {
         this._furnituresInfostree = param1.addChild(this._furnituresInfostreeFunc);
    }

    private void _furnituresInfostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._furnituresInfostree.addChild(this._furnituresInfosFunc);
            _loc3_++;
    }

    private void _furnituresInfosFunc(ICustomDataInput param1) {
         HavenBagFurnitureInformation _loc2_ = new HavenBagFurnitureInformation();
         _loc2_.deserialize(param1);
         this.furnituresInfos.push(_loc2_);
    }

}