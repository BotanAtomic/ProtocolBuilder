package package com.ankamagames.dofus.network.types.game.prism;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PrismGeolocalizedInformation extends PrismSubareaEmptyInfo implements INetworkType {

    private int protocolId = 434;
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private PrismInformation prism = ;
    private FuncTree _prismtree = ;
    private int _loc2_ = param1.readUnsignedShort();


    public int getTypeId() {
         return 434;
    }

    public PrismGeolocalizedInformation initPrismGeolocalizedInformation(int param1,int  param2,int  param3,int  param4,int  param5,PrismInformation  param6) {
         super.initPrismSubareaEmptyInfo(param1,param2);
         this.worldX = param3;
         this.worldY = param4;
         this.mapId = param5;
         this.prism = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.worldX = 0;
         this.worldY = 0;
         this.mapId = 0;
         this.prism = new PrismInformation();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PrismGeolocalizedInformation(param1);
    }

    public void serializeAs_PrismGeolocalizedInformation(ICustomDataOutput param1) {
         super.serializeAs_PrismSubareaEmptyInfo(param1);
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismGeolocalizedInformation(param1);
    }

    public void deserializeAs_PrismGeolocalizedInformation(ICustomDataInput param1) {
         super.deserialize(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._mapIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.prism = ProtocolTypeManager.getInstance(PrismInformation,_loc2_);
         this.prism.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PrismGeolocalizedInformation(param1);
    }

    public void deserializeAsyncAs_PrismGeolocalizedInformation(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._mapIdFunc);
         this._prismtree = param1.addChild(this._prismtreeFunc);
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element of PrismGeolocalizedInformation.worldX.");
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
            throw new Exception("Forbidden value (" + this.worldY + ") on element of PrismGeolocalizedInformation.worldY.");
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _prismtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.prism = ProtocolTypeManager.getInstance(PrismInformation,_loc2_);
         this.prism.deserializeAsync(this._prismtree);
    }

}