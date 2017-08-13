package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PaddockContentInformations extends PaddockInformations implements INetworkType {

    private int protocolId = 183;
    private int paddockId = 0;
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private int subAreaId = 0;
    private boolean abandonned = false;
    private Vector<MountInformationsForPaddock> mountsInformations;
    private FuncTree _mountsInformationstree;


    public int getTypeId() {
         return 183;
    }

    public PaddockContentInformations initPaddockContentInformations(int param1,int  param2,int  param3,int  param4,int  param5,int  param6,int  param7,boolean  param8,Vector<MountInformationsForPaddock>  param9) {
         super.initPaddockInformations(param1,param2);
         this.paddockId = param3;
         this.worldX = param4;
         this.worldY = param5;
         this.mapId = param6;
         this.subAreaId = param7;
         this.abandonned = param8;
         this.mountsInformations = param9;
         return this;
    }

    public void reset() {
         super.reset();
         this.paddockId = 0;
         this.worldX = 0;
         this.worldY = 0;
         this.mapId = 0;
         this.subAreaId = 0;
         this.abandonned = false;
         this.mountsInformations = new Vector.<MountInformationsForPaddock>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PaddockContentInformations(param1);
    }

    public void serializeAs_PaddockContentInformations(ICustomDataOutput param1) {
         super.serializeAs_PaddockInformations(param1);
         param1.writeInt(this.paddockId);
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
         }
         param1.writeShort(this.worldX);
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
         }
         param1.writeShort(this.worldY);
         param1.writeInt(this.mapId);
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         param1.writeBoolean(this.abandonned);
         param1.writeShort(this.mountsInformations.length);
         int _loc2_ = 0;
         while(_loc2_ < this.mountsInformations.length)
         {
            (this.mountsInformations[_loc2_] as MountInformationsForPaddock).serializeAs_MountInformationsForPaddock(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockContentInformations(param1);
    }

    public void deserializeAs_PaddockContentInformations(ICustomDataInput param1) {
         MountInformationsForPaddock _loc4_ = null;
         super.deserialize(param1);
         this._paddockIdFunc(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._mapIdFunc(param1);
         this._subAreaIdFunc(param1);
         this._abandonnedFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new MountInformationsForPaddock();
            _loc4_.deserialize(param1);
            this.mountsInformations.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockContentInformations(param1);
    }

    public void deserializeAsyncAs_PaddockContentInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._paddockIdFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._subAreaIdFunc);
         param1.addChild(this._abandonnedFunc);
         this._mountsInformationstree = param1.addChild(this._mountsInformationstreeFunc);
    }

    private void _paddockIdFunc(ICustomDataInput param1) {
         this.paddockId = param1.readInt();
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of PaddockContentInformations.worldX.");
         }
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of PaddockContentInformations.worldY.");
         }
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PaddockContentInformations.subAreaId.");
         }
    }

    private void _abandonnedFunc(ICustomDataInput param1) {
         this.abandonned = param1.readBoolean();
    }

    private void _mountsInformationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._mountsInformationstree.addChild(this._mountsInformationsFunc);
            _loc3_++;
         }
    }

    private void _mountsInformationsFunc(ICustomDataInput param1) {
         MountInformationsForPaddock _loc2_ = new MountInformationsForPaddock();
         _loc2_.deserialize(param1);
         this.mountsInformations.push(_loc2_);
    }

}