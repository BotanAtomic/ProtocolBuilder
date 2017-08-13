package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class MountInformationsForPaddock extends Object implements INetworkType {

    private int protocolId = 184;
    private int modelId = 0;
    private String name = "";
    private String ownerName = "";


    public int getTypeId() {
         return 184;
    }

    public MountInformationsForPaddock initMountInformationsForPaddock(int param1,String  param2,String  param3) {
         this.modelId = param1;
         this.name = param2;
         this.ownerName = param3;
         return this;
    }

    public void reset() {
         this.modelId = 0;
         this.name = "";
         this.ownerName = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_MountInformationsForPaddock(param1);
    }

    public void serializeAs_MountInformationsForPaddock(ICustomDataOutput param1) {
         if(this.modelId < 0)
         {
            throw new Exception("Forbidden value (" + this.modelId + ") on element modelId.");
         }
         param1.writeVarShort(this.modelId);
         param1.writeUTF(this.name);
         param1.writeUTF(this.ownerName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountInformationsForPaddock(param1);
    }

    public void deserializeAs_MountInformationsForPaddock(ICustomDataInput param1) {
         this._modelIdFunc(param1);
         this._nameFunc(param1);
         this._ownerNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountInformationsForPaddock(param1);
    }

    public void deserializeAsyncAs_MountInformationsForPaddock(FuncTree param1) {
         param1.addChild(this._modelIdFunc);
         param1.addChild(this._nameFunc);
         param1.addChild(this._ownerNameFunc);
    }

    private void _modelIdFunc(ICustomDataInput param1) {
         this.modelId = param1.readVarUhShort();
         if(this.modelId < 0)
         {
            throw new Exception("Forbidden value (" + this.modelId + ") on element of MountInformationsForPaddock.modelId.");
         }
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _ownerNameFunc(ICustomDataInput param1) {
         this.ownerName = param1.readUTF();
    }

}